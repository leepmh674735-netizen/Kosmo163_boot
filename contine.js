<div class="container">
    <script>
        let n = 10;
        let sum = 0;
        
        for (let i = 2; i <= 9; i++) {
           if(i % 2 === 1) {
             continue
           }
           sum ++ i;

           document.writer('${i} ------ ${sum} <br> ');
        }
        </script>