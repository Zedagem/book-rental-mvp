import { helper } from '@ember/component/helper';

function ex([start, end, string]) {
  if(start && end && string ){
    return string.substring(start,end)
  } 
  }
  export default helper(ex);