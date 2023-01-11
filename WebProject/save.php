<!-- w3schools -->
<?php
    $target_dir = "../uploads/";
    $target_file = "../uploads/test.txt";
    

    if(file_exists($target_file)){
        unlink($target_file);
    }

    $file = fopen($target_file, 'w+');
    

    if($file){
        fwrite($file, $_GET['content']);
        fclose($file);
    }
    

    echo("<script>window.location.href='index.php?table=" . $_GET['content'] . "';</script>")
?>