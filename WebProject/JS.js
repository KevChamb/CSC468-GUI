let table;
let hist;

window.onload = () => {
    table = new Table();
    hist = new History();

        if(window.location.href.includes("table=")){
        const arr =window.location.href.split("table=")[1];
        const builds = arr.split(",");
        builds.pop();
        let size = builds.length;
        for(let i=0; i<size; i++){
            let options = document.getElementById('select'+i);
            options.selectedIndex = builds[i];
            table.selectBuilding(i,builds[i],true);
        }
        
    }

    document.getElementById('addRow').addEventListener('click',(e)=>{
        table.addRow();
    })
    document.getElementById('reset').addEventListener('click',(e)=>{
        table.reset();
    })
    document.getElementById('save').addEventListener('click', (e) => {
       table.save();
    });
    document.getElementById('hotels').addEventListener('click', (e) =>{
        table.hotels();
    });

    document.getElementById('undo').addEventListener('click', (e) =>{
        table.undo();
    });
    document.getElementById('redo').addEventListener('click', (e) =>{
        table.redo();
    });
    document.getElementById('mixed').addEventListener('click', (e)=>{
        table.mixed();
    });
    

}

function setBuidling (id){
    table.selectBuilding(id);
    
}

//From w3schools
function setCookie(cname, cvalue, exdays) {
    var d = new Date();
    d.setTime(d.getTime() + (exdays * 24 * 60 * 60 * 1000));
    var expires = "expires=" + d.toUTCString();
    document.cookie = cname + "=" + cvalue + ";" + " SameSite=None; Secure" + ";path=/";
}
//From w3schools
function getCookie(cname) {
    var name = cname + "=";
    var decodedCookie = decodeURIComponent(document.cookie);
    var ca = decodedCookie.split(';');
    for (var i = 0; i < ca.length; i++) {
        var c = ca[i];
        while (c.charAt(0) == ' ') {
            c = c.substring(1);
        }
        if (c.indexOf(name) == 0) {
            return c.substring(name.length, c.length);
        }
    }
    return "";
}
