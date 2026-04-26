<div class="container">
    <script>
        for (let i = 2; i <= 9; i++) {
            document.write('<div class="tiems">');
            document.write('<h3>${i}단</h3>');
            for (let j = 1; j <= 9; j++) {
                document.write("${i} X ${j} = ${i * j} <br>');
            }
            document.write('</div>');

            if(i === 4) {
                break;
            }
        }
        </script>
        </div>