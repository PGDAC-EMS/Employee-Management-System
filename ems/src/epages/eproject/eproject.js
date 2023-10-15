import axios from 'axios'
import { useState, useEffect } from 'react'
import { useHistory } from 'react-router-dom'
import { url } from '../../ecommons/constants'
import '../ecards.css'
import { toast} from "react-toastify"

const EProject = () => {

  const [tasks, setTasks] = useState([])
  const history = useHistory()
  useEffect(() => {
    console.log(`project component got loaded`)
    getProject()
  }, [])

  const emp = JSON.parse(localStorage.getItem('loginUser'));
  const getProject = () => {
    if (emp.email.length === 0) {
      toast.error('Select email')
    } else {
     
      //creating an object of form data
      const data = new FormData()

      //append method is used to add key value pairs
      data.append('empId', emp.empId)

      /*using the Axios library to make an HTTP POST request to a server-side API to retrieve a list of tasks for a user, and then updating the state of the component to display the list of tasks to the user. If an error occurs, an error message is displayed to the user using the toast method.*/
      axios.post(url + '/user/gettask', data).then((response) => {
        const result = response.data
        console.log(result);

        if (result.status === 'success') {
          setTasks(result.data)
          // localStorage.setItem('project', JSON.stringify(result.data))
          // console.log(result.data)
        } else {
          toast.error('error while loading list of project')
        }
      })
    }
  }

  return (
    <div className="card-project">
      <h1 className="page-title">Project</h1>
      <table className="table table-dark table-hover">
        <thead>
          <tr>
            <th>id</th>
            <th>Project Name</th>
            <th>Client Name</th>
            <th>End Date</th>
            <th>Status</th>
            <th>Details</th>
          </tr>
        </thead>
        <tbody>
          {tasks.map((task) => {
            return <tr>
              <td>{task.project.pId}</td>
              <td>{task.project.pName} </td>
              <td>{task.project.client.cName} </td>
              <td>{task.project.pEndDate}</td>
              <td>{task.project.pStatus}</td>
              <td> <button
                onClick={() => {
                  history.push('/edashboard/eviewproject', { task: task })
                }}
                className="btn btn-success btn-sm">
                View
              </button>
              </td>
            </tr>
          })}
        </tbody>
      </table>
    </div>
  )
}

export default EProject