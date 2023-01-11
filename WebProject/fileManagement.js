window.onload = function(){

}

async function load(btn){
    let response = await fetch('../uploads/'+ btn.id);

    let set = await response.text();

    window.location.href = "index.php?table="+set;
}