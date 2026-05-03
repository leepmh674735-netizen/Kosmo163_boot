var greeting ='안녕하세요, ';
var name = '웹지니';
var message = ', 주문내역을 확인해 주세요';

var welcome = greeting  + name + message;

var sign = 'Montague House';
var tiles = sign.length;
var subTotal = tiles * 5;
var shipping = 7;
var grandTotal = subTotal + shipping;

var el = document.getElementById('greeting');
el.textContent = welcome;

var elSign = document.getElementById('userSign');
elSign.textContent = sign;

var elTiles = document.getElementById('tiles');
elTiles.textContent = titles;

var elSubTotal = document.getElementById('shipping');
elSubTotal.textContent = '$'+ subTotal;

var elSubTotal = document.getElementById('shipping');
elSubTotal.textContent = '$' + shipping;

var elGrandTotal = document.getElementById('grandTotal');
elGrandTotal.textContent = '$' + grandTotal;