import axios from 'axios'
import { useState, useEffect } from 'react'
import { useHistory } from 'react-router-dom'
import { url } from '../../commons/constants'
import { toast } from 'react-toastify'

const OngoingProjectlist = () => {
  // maintain the state
  const [projects, setProjects] = useState([])

  const history = useHistory()

  useEffect(() => {
    console.log(`project component got loaded`)
    getProjects()
  }, [])

  const getProjects = () => {
    axios.get(url + '/admin/ongoningprojects').then((response) => {
      const result = response.data
      // console.log(result);
      if (result.status === 'success') {
        setProjects(result.data)
        // console.log(result.data)
        // localStorage.setItem('projList', JSON.stringify(result.data));
      } else {
        toast.error('error while loading list of project')
      }
    })
  }

  return (
    <div>
      <h1 className="page-title">Projects</h1>
      <table className="table table-dark table-hover">
        <thead>
          <tr>
            <th>Id</th>
            <th>Project Name</th>
            <th>Client Name</th>
            <th>Start Date</th>
            <th>End Date</th>
            <th>Status</th>
            <th>Edit / View</th>
          </tr>
        </thead>
        <tbody>
          {projects.map((project) => {
    
            return <tr>
              <td>{project.pId}</td>
              <td>{project.pName} </td>
              <td>{project.client.cName} </td>
              <td>{project.pStartDate}</td>
              <td>{project.pEndDate}</td>
              <td>{project.status}</td>
              <td>
                <button
                  onClick={() => {
                    history.push('/dashboard/viewproject', { project: project })
                  }}
                  className="btn btn-success btn-sm">
                  View Details
                </button>
              </td>
            </tr>
          })}
        </tbody>
      </table>
    </div>
  )
}

export default OngoingProjectlist
