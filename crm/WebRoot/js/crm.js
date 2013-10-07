function click(e) {
 if (document.all) {
  if (event.button==1||event.button==2||event.button==3) {
   oncontextmenu='return false';
  }
 }
 if (document.layers) {
  if (e.which == 3) {
   oncontextmenu='return false';
  }
 }
}
if (document.layers) {
 document.captureEvents(Event.MOUSEDOWN);
}
document.onmousedown=click;
document.oncontextmenu = new Function("return false;")