function getWeekday(day_value) {
    let date = new Date(day_value);
    let day = date.toLocaleString('en-us', {weekday: 'long'});
    return day;
}

function changeDateFormat(day){
    let date = new Date(day);
    const _date = new Date(date); // yyyy-MM-dd
    let  new_day = _date.getDate() + '/' + (_date.getMonth()+1); // dd/mm
    return new_day;
}

const nodeList = document.querySelectorAll(".day_title");
const nodeList2 = document.querySelectorAll(".day_title2");

for (let i = 0; i < nodeList.length; i++) {
  let temp = nodeList2[i].innerHTML;
  nodeList[i].innerHTML = getWeekday(temp);
  nodeList2[i].innerHTML = changeDateFormat(temp);
}
