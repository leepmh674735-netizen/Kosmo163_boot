var saying = 'Home sweet home ';

length     .toUpperCase()   .toLowerCase()     charAt()  indexOf()  lastIndexof() substring()
split()    trim()     replace()

saying.length;
saying.toUpperCase();
saying.toLowerCase();
saying.charAt(12);
saying.indexOf('ee');
saying.lastIndexOf('e');
saying.substring(8,14);
saying.split('')
saying.trim();
saying.replace('me', 'w');

var saying ='Home sweet home ';
var msg ='<h2>길이</h2><p>' + saying.length + '</p>';
msg += '<h2>대문자</h2><p>' + saying.toUpperCase() + '</p>';
msg += '<h2>소문자</h2><p>' + saying.toLowerCase() + '</p>';
msg += '<h2>문자  인덱스: 12</h2><p>' + saying.charAt(12) + '</p>';
msg += '<h2>ee의 첫번째 위치</h2><p>'+  saying.indexof('ee') +'</p>';
msg += '<h2>e의 마지막위치</h2><p>' + saying.lastIndexOf('e') + '</p>';
msg += '<h2>인덱스 범위 : 8-14</h2><p>' + saying.substring(8, 14) + '</p>';
msg += '<h2>replace</h2><p>' +saying.replace('me', 'w') + '</p>';

var el = document.getElementById('info');
el.innerHTML = msg;