import { Link } from 'react-router-dom'
import './ecards.css'
import Project from '../eimages/task.jpg';
import task from '../eimages/task2.png';

const EHome = () => {
  return (
    <div className="card-home">
      <div className="mb-3">
        <div className="cardhome-image"></div>
        <br></br>
        <table className="table table-sm" border="0">
          <tr>
            <td width="50%">
              <Link to="/edashboard/eaccepttask" className="Link"><img src={task} alt="task " /></Link>
            </td>
            <td>
              <Link to="/edashboard/emyproject" className="Link"><img src={Project} alt="Project Management" /></Link>
            </td>
          </tr>
          <tr align="center">
            <td>Task</td>
            <td>Project</td>
          </tr>
        </table>
      </div>
    </div>
  )
}

export default EHome
