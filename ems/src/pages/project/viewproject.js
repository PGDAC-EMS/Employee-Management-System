
import axios from 'axios'
import { useState, useEffect } from 'react'
import { Link, useHistory, useLocation } from 'react-router-dom'
import { url } from '../../commons/constants'
import '../signup.css'
import {toast} from 'react-toastify'

const Viewproject = () => {
  const [tasks, setTasks] = useState([])

  const history = useHistory()
  const location = useLocation()
  const project = location.state.project

  let sDate = undefined
  let eDate = undefined
  let subDate = undefined
  if (project.pstartDate != null) {
    sDate = project.pstartDate.substring(0, 10);
  }
  if (project.pendDate != null) {
    eDate = project.psndDate.substring(0, 10);
  }
  if (project.pSubmittedDate != null) {
    subDate = project.pSubmittedDate.substring(0, 10);
  }

  useEffect(() => {
    console.log(`Client component got loaded`)
    getTasksofProject()
  })

  const getTasksofProject = () => {
    const data = new FormData()
    data.append('project', project.pid)
    axios.post(url + '/admin/gettaskofProject', data).then((response) => {
      const result = response.data
      // console.log(result);
      if (result.status === 200) {
        setTasks(result.data)
        // console.log(result.data)
        // localStorage.setItem('taskList', JSON.stringify(result.data));
      } else {
        toast.error('Error while loading list')
      }
    })
  }

  return (
    <div className="cardViewList">
      <table class="table table-dark table-hover">
        <tbody>
          <tr><td colSpan="3" align="center" ><h2> Project Details </h2></td></tr>
          <tr> <th scope="row">Project Id</th> <td>:-</td>  <td>{project.id} </td> </tr>
          <tr> <th scope="row">Name</th> <td>:-</td> <td>{project.pname}</td>  </tr>
          <tr> <th scope="row">Client Name</th> <td>:-</td> <td> {project.client.cname} </td> </tr>
          <tr> <th scope="row">Description</th> <td>:-</td> <td> {project.pdesc} </td> </tr>
          <tr> <th scope="row">Credited By</th> <td>:-</td> <td> {project.pcreatedBy} </td> </tr>
          <tr> <th scope="row">Start Date</th> <td>:-</td> <td> {sDate} </td> </tr>
          <tr> <th scope="row">End Date</th> <td>:-</td> <td> {eDate} </td> </tr>
          <tr> <th scope="row">Submitted Date</th> <td>:-</td> <td> {subDate} </td> </tr>
          <tr> <th scope="row">Progress</th> <td>:-</td> <td> {project.pprogress} </td> </tr>
          <tr> <th scope="row">Report</th> <td>:-</td> <td> {project.preport} </td> </tr>
          <tr> <th scope="row">Status</th> <td>:-</td> <td> {project.pstatus} </td> </tr>
        </tbody>
      </table>
      <div align="center">
        <button onClick={() => {
          history.push('/dashboard/editproject', { project: project })
        }}
          className="btn btn-success">
          Edit Project
        </button> &nbsp;&nbsp;&nbsp;
        <Link to="/dashboard/projectlist" className="Link"><button className="btn btn-info">Back to Project List</button>
        </Link></div>
      <div><br></br>
        <h3 className="page-title">Project Tasks:{project.pid}</h3>
        <table className="table table-striped ">
          <thead>
            <tr>
              <th>Id</th>
              <th>Name</th>
              <th>Project Name</th>
              <th>Employee Name</th>
              <th>Accept Status</th>
              <th>End Date</th>
              <th>Status</th>
            </tr>
          </thead>
          <tbody>
            {tasks.map((task) => {
              return <tr>
                <td>{task.tId}</td>
                <td>{task.tName} </td>
                <td>{task.project.pName}</td>
                <td>{task.emp.firstName} {task.emp.lastName}</td>
                <td>{task.approvalStatus}</td>
                <td>{task.tEndDate}</td>
                <td>{task.tStatus}</td>
              </tr>
            })}
          </tbody>
        </table>
      </div>
    </div>
  )
}

export default Viewproject
