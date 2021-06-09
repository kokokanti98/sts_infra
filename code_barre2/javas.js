var base_url = 'http://localhost:8089/';

function see_all_barcode() {
    // using the Fetch API
    $.ajax({
        url: base_url + 'qrcodes',
        type: "GET",
        crossDomain: true,
        crossOrigin: true,
        success: function (data, msg) {
            var text = '';
            $.each(data, function (key, val) {
                console.log('id du qrcode:' + val.id + '\nreduction: ' + val.reduction);
                var id_th_elem = 'num_bar_code' + val.id + '';
                text += '<tr>';
                text += '<th scope="row" id=' + id_th_elem +'>' + val.id + '</th>';
                text += '<td>';
                text += '<button type="button" class="btn btn-primary" onclick="see_bar_code(' + id_th_elem + ')">Voir image</button>';
                text += '</td>';
                text += '</tr>';
            });
            $("#tableau_bar_code").html(text);
        },
        error: function (msg) {
            console.table(msg);
        }
    });

}
function see_bar_code(id_num_code) {
    //see the html element
    //console.log(id_num_code);
    //see in console the content of the th
    console.log(id_num_code.textContent);
    JsBarcode("#barcode", id_num_code.textContent);
}

