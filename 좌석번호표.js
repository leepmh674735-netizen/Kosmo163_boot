<script>

    <docunent.write('<table>');
        for (let i = 0; i < rowNum; i++) {
            document.write('<tr>');
        seatNo = i *colNum; 
       if (seatNo > memNum) braek;
        document.write("<td 좌석 ${seatNo} </td>'); 
       }
    document.write('/tr');
    }
    document.write('/table>');
</script>