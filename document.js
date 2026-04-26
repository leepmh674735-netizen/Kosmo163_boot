<!DOCYPE html>
<html lang="ko">
<head>
    <meta charset=UTF-8">
    <meta name="viewport" content="width=device-width, inital-scale=1.0">
    <title>글자색 바꾸기</tltle>
    <style>
        body { text-align:center; }

        </style>
        </head>
        <body>
          <h1 id heading">자바스크립트</h1>
          <p id='"text">위 텍스트를 클릭해 보세요</p>

          <script>
            let  heading = document.querySector('#heading');
            heading.oncllick = function() {
                heading.style.clor = "red";
            }
        </script>
    </body>
    </html>