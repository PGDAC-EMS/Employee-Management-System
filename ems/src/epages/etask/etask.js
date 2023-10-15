import axios from 'axios'
import { useState, useEffect } from 'react'
import { useHistory } from 'react-router-dom'
import { url } from '../../ecommons/constants'
import '../ecards.css'
import { toast} from 'react-toastify'

const ETask = () => {
  const [tasks, setTasks] = useState([])
  useEffect(() => {
    console.log(`Tasklist component got loaded`)
    getTasks()
  }, [])

  const history = useHistory()

  const emp = JSON.parse(localStorage.getItem('loginUser'));
  const getTasks = () => {
    if (emp.email.length === 0) {
      toast.error('Select email')
    } else {
      const data = new FormData()
      data.append('empId', emp.empId)

      axios.post(url + '/user/gettask', data).then((response) => {
        const result = response.data
        // console.log(result);
        if (result.status === 'success') {
          setTasks(result.data)
          // localStorage.setItem('Task', JSON.stringify(result.data));
          // console.log(result.data)
        } else {
          toast.error('error while loading list of task')
        }
      })
    }
  }

  return (
    <div className="card-task">
      <h1 className="page-title">Tasks</h1>
      <table className="table table-dark table-hover">
        <thead>
          <tr>
            <th>Task Id</th>
            <th>Name</th>
            <th>Project Name</th>
            <th>Status</th>
            <th>End Date</th>
            <th>Details</th>
            <th>Submit</th>
          </tr>
        </thead>
        <tbody>
          {tasks.map((task) => {
            return <tr>
              <td>{task.tId}</td>
              <td>{task.tName} </td>
              <td>{task.project.pName}</td>
              <td>{task.tStatus}</td>
              <td>{task.tEndDate}</td>
              <td> <button
                onClick={() => {
                  history.push('/edashboard/eviewtask', { task: task })
                }}
                className="btn btn-info btn-sm">
                View
              </button>
              </td>
              <td> <button
                onClick={() => {
                  history.push('/edashboard/esubmittask', { task: task })
                }}
                className="btn btn-success btn-sm">
                Submit
              </button>
              </td>
            </tr>
          })}
        </tbody>
      </table>
    </div>
  )
}

export default ETask