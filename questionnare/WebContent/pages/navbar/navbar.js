function navbar_show_hide(){
    if(document.getElementById("ulLeft").style.display=="none"){
       $("#ulLeft").slideDown(600);
    }else{
       $("#ulLeft").slideUp(600);
    }
}