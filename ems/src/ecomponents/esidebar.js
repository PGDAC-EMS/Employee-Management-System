import {Link} from 'react-router-dom'
import './esidebar.css'

const ESidebar = () => {
    return (
        <div id="wrapper">
        <div id="sidebar-wrapper">
            <ul className="sidebar-nav">
                <li> <div className=""></div> </li>
                <br/><br/>
                <li> <Link to="/edashboard/ehome" className="nav-link">Dashboard</Link> </li>
                <li> <Link to="/edashboard/emytask" className="nav-link">Task</Link> </li>
                <li> <Link to="/edashboard/emyproject" className="nav-link">Projects</Link> </li>
                <li> <Link to="/edashboard/emyprofile" className="nav-link">Profile</Link> </li>
                <li> <Link to="/edashboard/ehelp" className="nav-link">Help</Link> </li>
                <li> <Link to="/edashboard/elogout" className="nav-link">Logout</Link> </li>
            </ul>
        </div>
        </div>
    )
}

export default ESidebar