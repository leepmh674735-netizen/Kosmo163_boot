<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>좌석 배치 프로그램</title>

<style>
body {
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    height: 100vh;
    font-family: Arial, sans-serif;
}

h2 {
    margin-bottom: 10px;
}

input {
    padding: 8px;
    width: 120px;
    margin-right: 5px;
}

button {
    padding: 8px 12px;
    cursor: pointer;
}

table, td {
    border: 1px solid #ccc;
    border-collapse: collapse;
}

td {
    padding: 10px;
    font-size: 0.9em;
    width: 50px;
    height: 40px;
    text-align: center;
}
</style>
</head>

<body>

<h2>좌석 배치 프로그램</h2>

<div>
    <input type="number" id="person" placeholder="인원 수 입력">
    <button onclick="makeSeat()">확인</button>
</div>

<br>

<div id="result"></div>

<script>
function makeSeat() {

    let count = Number(document.getElementById("person").value);
    let colNum = 4;   // 한 줄에 4자리
    let rowNum = Math.ceil(count / colNum);

    let seatNum = 1;
    let table = "<table>";

    for(let i = 0; i < rowNum; i++) {
        table += "<tr>";

        for(let j = 0; j < colNum; j++) {

            if(seatNum <= count) {
                table += "<td>" + seatNum + "</td>";
                seatNum++;
            } else {
                table += "<td></td>";
            }

        }

        table += "</tr>";
    }

    table += "</table>";

    document.getElementById("result").innerHTML = table;
}
</script>

</body>
</html>