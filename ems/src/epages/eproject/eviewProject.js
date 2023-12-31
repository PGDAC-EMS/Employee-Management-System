import { Link, useLocation } from 'react-router-dom'
import '../esignup.css'

const EViewTask = () => {

  /* useLocation hook to get information about the current URL location of the application. This information is stored in the location variable as an object with several properties, including pathname, search, hash, and state.*/
  const location = useLocation()
  /*const project = location.state.task retrieves the task property from the state object of the location variable and stores it in the project variable.*/ 
  const project = location.state.task

  let startDate = undefined
  let endDate = undefined
  let submitDate = undefined

  if (project.project.pStartDate != null) {
    startDate = project.project.pStartDate.substring(0, 10);
  }
  if (project.project.pEndDate != null) {
    endDate = project.project.pEndDate.substring(0, 10);
  }
  if (project.project.pSubmittedDate != null) {
    submitDate = project.project.pSubmittedDate.substring(0, 10);
  }

  return (
    <div className="cardSignup">
      <table class="table table-dark table-hover">
        <tbody>
          <tr>
             <th scope="row" colSpan="3" >
                <center>
                  <h3>Project Info</h3>
                </center> 
              </th>
              </tr>
          <tr>
             <th scope="row">Project Id</th> 
                <td>:-</td>  
                <td>{project.project.pId} </td>
             </tr>
          <tr>
             <th scope="row">Project Name</th> 
             <td>:-</td> 
             <td>{project.project.pName}</td> 
           </tr>
          <tr>
             <th scope="row">Start Date</th> 
             <td>:-</td> 
             <td> {startDate}</td>
          </tr>
          <tr> 
            <th scope="row">End Date</th> 
            <td>:-</td> 
            <td> {endDate} </td> 
          </tr>
          <tr> 
            <th scope="row">Submitted Date</th> 
            <td>:-</td> 
            <td> {submitDate} </td> 
          </tr>
          <tr> 
            <th scope="row">Project status</th> 
            <td>:-</td> 
            <td> {project.project.pStatus} </td> 
          </tr>
          <tr> 
            <th scope="row">Project Description</th> 
            <td>:-</td> 
            <td> {project.project.pDesc} </td> 
            </tr>
          <tr> 
            <th scope="row">Project Report</th> 
            <td>:-</td> 
            <td> {project.project.pReport} </td> 
            </tr>
          <tr> 
            <th scope="row">Project Progress</th> 
            <td>:-</td> 
            <td> {project.project.pProgress} </td> 
          </tr>
        </tbody>
      </table>
      <div className="mb-3" align="center">
        <Link to="/edashboard/emyproject" className="Link"><button className="btn btn-info">Back to Project</button> </Link>
      </div>
    </div>
  )
}

export default EViewTask