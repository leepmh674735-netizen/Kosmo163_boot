function getSize(width, height, depth) {
    var area = width * height;
    var volume = width * height * depth;
    var sizes = [area, volume];
    return sizes;
}

var areaOne = getSize(3, 2, 3)[0];
var volumeOne = getSize(3, 2, 3)[1];

var hotel = {
    
    name:'Quay',
    rooms: 40,
    booked: 25,
    gym: true,
    roomTypes: ['트윈', '더블', '스위트'],

    checkAvailability:function() {
        return this.rooms - this.booked;
    }
};