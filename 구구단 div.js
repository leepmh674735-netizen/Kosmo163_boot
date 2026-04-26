<head>

    link rel="stylesheet" href="css/timestable.css">
</head>
<body>
    <h1>구구단</h1>
    <div class="container">
        <script>
            for (let i = 2; i <=9; i++) {
                document.write('<div claass=time">');
                document.writer('<h3>${i}단</h3>');
                for (let j = 1; j <=9; j++) {
                    document.write('${i} X ${j} = ${i * j} <br>');
                }
                document.writer("</div>');
            }
            </script>
       </div>
  </body>
