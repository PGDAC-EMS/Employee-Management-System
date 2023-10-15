import {Route, Switch, BrowserRouter} from 'react-router-dom'
import EHome from './ehome'
import ETask from './etask/etask'
import EViewTask from './etask/eviewTask'
import EAcceptTask from './etask/eacceptTask'
import ESubmitTask from './etask/esubmitTask'
import EProject from './eproject/eproject'
import EViewProject from './eproject/eviewProject'
import EProfile from './eprofile'
import EEditProfile from './eeditProfile'
import EHelp from './ehelp'
import ELogout from './elogout'
import ESidebar from '../ecomponents/esidebar'
import './edashboard.css'
import epageNotFound from './epageNotFound'

const EDashboard = () => {

  const details = JSON.parse(localStorage.getItem('loginUser'));
    return (
       <div className="container">
        <BrowserRouter>
       <div className="fixed"> 
      <ESidebar />
       </div>
      <div className="flex-item" >
        <p align="right">user : <b> {details.firstName} {details.lastName} </b> ({details.designation})  </p>
        <Switch>
        <Route path="/edashboard/ehome" component={EHome} />
        <Route path="/edashboard/emytask" component={ETask} />
        <Route path="/edashboard/eaccepttask" component={EAcceptTask} />
        <Route path="/edashboard/emyproject" component={EProject} />
        <Route path="/edashboard/emyprofile" component={EProfile} />
        <Route path="/edashboard/eeditprofile" component={EEditProfile} />
        <Route path="/edashboard/esubmittask" component={ESubmitTask} />
        <Route path="/edashboard/eviewtask" component={EViewTask} />
        <Route path="/edashboard/eviewproject" component={EViewProject} />
        <Route path="/edashboard/ehelp" component={EHelp} />
        <Route path="/edashboard/elogout" component={ELogout} />
        <Route path="/edashboard/*" component={epageNotFound} />
        </Switch>
      </div>
      </BrowserRouter>
      </div>
    )
}

export default EDashboard