import { useHistory } from 'react-router-dom'
import './ecards.css'
import { toast} from 'react-toastify'

const ELogout = () => {
  const history = useHistory()

  const signout = () => {
    localStorage.clear()
    toast.success('LogOut Successful')
  }
  const cancle = () => {
    history.push('/edashboard/ehome')
  }

  return (
    <div className="card-logout">
      <br></br><br></br>
      <div className="mb-3">
        <div className=""></div>
        <br></br><br></br>
        <h2><label className="input-label"><b>Logging Out?</b></label><br></br></h2>
        <br></br><br></br>
        <a href="/"><button onClick={signout} className="btn btn-success">
          Yes
        </button></a>
        &nbsp;&nbsp;&nbsp;
        <button onClick={cancle} className="btn btn-danger">
          I'd like to stay
        </button><br></br>
      </div>
    </div>
  )
}

export default ELogout
