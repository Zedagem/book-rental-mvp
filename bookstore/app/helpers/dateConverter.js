import { helper } from '@ember/component/helper';
const monthMap = new Map([
  ["01", "January"],
  ["02", "Febuary"],
  ["03", "March"],
  ["04", "April"],
  ["05", "May"],
  ["06", "June"],
  ["07", "July"],
  ["08", "August"],
  ["09", "September"],
  ["10", "October"],
  ["11", "Novemeer"],
  ["12", "December"],
])
function dateConverter([publishedDate]) {
  if (publishedDate) {
    let [year, month, day] = publishedDate.substring(0, 10).split("-");

    return monthMap.get(month) + " " + day + " " + year;
  }
}
export default helper(dateConverter);