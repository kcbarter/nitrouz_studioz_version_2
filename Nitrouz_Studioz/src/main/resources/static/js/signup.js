var status = "more";

function readMore() {
  var text = "Connect with members of our site. Leave comments, follow people and more. Your nickname, profile image, "
      + "and public activity will be visible on our site.";
  if(status === "more"){
    document.getElementById("info").innerHTML = text;
    document.getElementById("readMore").innerText = " Read Less";
    status = "less";
  }
  else {
    document.getElementById("info").innerHTML = "";
    document.getElementById("readMore").innerText = " Read More";
    status = "more";
  }
}