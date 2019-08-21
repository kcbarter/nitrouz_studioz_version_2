var header = document.getElementById("nav");
var btns = header.getElementsByClassName("navbar");
// var activeButton = document.getElementsByClassName("home");
// activeButton.className.replace(" home", " active");

for(var i = 0; i < btns.length; i++) {
  btns[i].addEventListener("click", function () {
    var current = document.getElementsByClassName("active");
    current[0].className = current[0].className.replace(" active", "");
    this.className += " active";
  });
}