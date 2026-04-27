let heading = document.getElementById("heading");
heading.onclick = function () {
    heading.style.color = "red";
}
<body>
    <h1 id="heading">자바스크립트</h1>
    <p id="text">위 텍스트를 클릭해 보세요</p>

    <script src="change_color.js"></script>
</body>