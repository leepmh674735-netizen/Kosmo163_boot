var hotel = {
    name : 'Park',
    rooms : 120,
    booked : 77,
};

hotel.gym = true;
hotel.pool = false;
delete hotel.booked;

var elName =document.getElementById('hotelName');
elName.textContent = hotel.name;

var elPool = document.getElementById('pool');
elPool.className = '수영장: ' + hotel.pool;

var elGym = document.getElementById('gym');
elGym.className = '체력단련실:  ' + hotel.gym;

Window Document History Location Navigator  Screen

document.title
document.lastModified
document.URL
document.domain

document.write()
document.getElementById()
document.querySelectorAll()
document.createElement()
document.createTextNode()

var msg = '<p><b>페이지 제목: </b>' + document.title + '<br />';
msg  += '<b>페이지 주소: </b>' + document.URL + '<br />';
mag += '<b>최종 수정일: </b>' + document.lastModified + </p';

var el = document.getElementById('footer');
el.innerHTML = msg;