import axios from 'axios'
import { useState, useEffect } from 'react'
import { useHistory } from 'react-router-dom'
import { url } from '../../commons/constants'
import '../signup.css'
import {toast} from 'react-toastify'

const Addproject = () => {
  const [projectName, setProjectName] = useState('')
  const [description, setDescription] = useState('')
  const [createdBy, setCreatedBy] = useState('')
  const [startDate, setStartDate] = useState('')
  const [endDate, setEndDate] = useState('')
  const [cid, setCid] = useState(0)
  const [pstatus] = useState('On Going')
  const [clients, setClients] = useState([])

  const history = useHistory()
  const emp = JSON.parse(localStorage.getItem('loginUser'));

  useEffect(() => {
    console.log(`Client component got loaded`)
    getDepts();
    createdBySet()
  },[])

  const getDepts = () => {
    axios.get(url + '/admin/getclient').then((response) => {
      const result = response.data
      console.log(result);
      if (response.status === 200) {
        setClients(result)
      } else {
        toast.error('error while loading list of clients')
      }
    })
  }
// they are using pcreated by id but instead seetiing it to string
  const createdBySet = () => {
    setCreatedBy(String(emp.id));
  }

  const validateName = (name) => {
    const re = /^[A-Za-z\s]+$/
    return re.test(name);
  }

  const addUserToDB = () => {
    const sDate = new Date(startDate)
    const eDate = new Date(endDate)
    if (eDate < sDate) {
      toast.error('End Date should be Greater then Start Date')
    } else if (projectName.length === 0) {
      toast.error('Enter Project Name')
     
    } else if (description.length === 0) {
      toast.error('Enter Description')
      
    }  else if (createdBy.length === 0) {
      toast.error('Unable to get information of current employee')
     
    }  else if (startDate.length === 0) {
      toast.error('Enter Start Date')
      
    } else if (endDate.length === 0) {
      toast.error('Enter End Date')
    } else if (!validateName(projectName)) {
      toast.error('Invalid Project Name')
    } else if (description.length > 900) {
      toast.error('Description should be less than 900 Words')
    } else {
      
      const data = {
        pName: projectName,
        pDesc: description,
        pCreatedBy: createdBy,
        pStartDate: startDate,
        pEndDate: endDate,
        clientId: cid,
        pStatus: pstatus
      };

      axios.post(url + '/admin/addproject', data).then((response) => {
        const result = response.data
        if (result.status === 200) {
          toast.success('Project added Successfully')
          
          // go to SignIN page
          history.push('/dashboard/projectlist')
        } else {
          toast.error('error while adding project')
        
        }
      })
    }
  }

  return (
    <div class="cardSignup add-in-db">
      <div className="row">
        <h2><center> Add Project </center> </h2><br/><br/><br/>
        <div className="col">
          <label class="input-label">Project Name</label><br></br>
          <input
            onChange={(e) => {
              setProjectName(e.target.value)
            }}
            type="text" className="form-control" />
        </div>
        <div className="col">
          <label class="input-label">Client Name</label><br></br>
          <select
            onChange={(e) => {
              setCid(e.target.value)
            }}
            className="form-control" >
            <option value=""> Select Client </option>
            {clients.map((client) => {
              return (
                <option key={client.id} value={client.id}> {client.cname} </option>)
            })}
          </select>
        </div>
      </div><br></br>
      <div className="row">
        <div className="col" >
          <label className="input-label">Start Date</label><br></br>
          <input
            onChange={(e) => {
              setStartDate(e.target.value)
            }}
            type="date" className="form-control" />
        </div>
        <div className="col" >
          <label class="input-label">End Date</label><br></br>
          <input
            onChange={(e) => {
              setEndDate(e.target.value)
            }}
            type="date" className="form-control" />
        </div>
      </div><br></br>
      <div className="row">
        <div className="col">
          <label className="input-label">Project Description</label><br></br>
          <textarea
            onChange={(e) => {
              setDescription(e.target.value)
            }}
            name="message" rows="8" maxlength="900" className="form-control" />
        </div>
      </div>
      <br></br>
      <div className="mb-3" align="center">
        <button onClick={addUserToDB} className="btn btn-success">
          Add Project
        </button><br></br><br></br>
      </div>
    </div>
  )
}

export default Addproject