import axios from 'axios'
const reques = axios.create({
  baseURL: 'http://localhost:8080'
})
export default reques
