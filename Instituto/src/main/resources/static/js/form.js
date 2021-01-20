// '.tbl-content' consumed little space for vertical scrollbar, scrollbar width depend on browser/os/platfrom. Here calculate the scollbar width .
$(window).on("load resize ", function() {
    var scrollWidth = $('.tbl-content').width() - $('.tbl-content table').width();
    $('.tbl-header').css({'padding-right':scrollWidth});
  }).resize();

  function confirmEliminar(id)
  {
    var respuesta = confirm("¿Estas Seguro?")
  
    if(respuesta == true)
    {
      return true;
    }
    else
    {
      return false; 
    }
  }