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