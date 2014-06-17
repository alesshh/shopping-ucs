;$(function() {
	$(".date").mask("99/99/9999");
	$(".zip").mask("99999-999");
	$(".phone").mask("(99) 9999-9999?9");
	$(".cnpj").mask("99.999.999/9999-99");
	$(".cpf").mask("999.999.999-99");
	$(".currency").maskMoney({prefix: 'R$', allowNegative: false});
});