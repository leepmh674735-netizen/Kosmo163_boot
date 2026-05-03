var hotel = {
    name : 'Quay',
    rooms ; 40,
    booked : 25,
    CheckAvailability : function() {
        var free = this.rooms - this.booked;
        return free;
    }
};

var  elName = document.getElementById('hotelName');
elName.textContent = hotel.name;

var elRoms = document.getElementById('rooms');
elRooms.textContent = hotel.CheckAvailability();

var quayHotel = new Hotel('Quay', 40, 25);
var packHotel = new Hotel('Park', 120, 77)
 
function Hotel(name, rooms, booked) {

    this.name = name;
    this.rooms = rooms;
    this.booked= booked;

    this.CheckAvailability = function() {
        return this.room - this.booked;
    }
}