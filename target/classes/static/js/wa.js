$('#confirmacaoExclusaoModal').on('show.bs.modal', function (event) {
	
	var button = $(event.relatedTarget);
	
	var codigo = button.data('codigo');
	var nome = button.data('descricao');
	
	var modal = $(this);
	var form = modal.find('form');
	var action = button.data('url-delete');
	
	
	form.attr('action', action + codigo); 
	
	modal.find('.modal-body span').html('Tem certeza que deseja excluir <strong>' + nome + '</strong>?');
	
});

$(function() {
	$('[rel="tooltip"]').tooltip();	
		
});


$(document).ready( function () {
    $('#id_tabelaFuncioanrios, #id_tabelaVagas, #id_tabelaHistorico').DataTable({
"language": {
                "lengthMenu": "Exibindo _MENU_ registros por página",
                "info": "Mostrando página <strong style='font-size:13pt;'>_PAGE_</strong> de _PAGES_",
                "infoEmpty": "Nenhum registro cadastrado no sistema",
                "infoFiltered": "(filtrado de _MAX_ registros no total)",
                "sInfoPostFix": "",
                "sInfoThousands": ".",
                "sLoadingRecords": "Carregando...",
                "sProcessing": "Processando...",
                "sZeroRecords": "Nenhum registro encontrado",
                "sSearch": "Pesquisar",
                "oPaginate": {
                    "sNext": "Próximo",
                    "sPrevious": "Anterior",
                    "sFirst": "Primeiro",
                    "sLast": "Último"
                },
                "oAria": {
                    "sSortAscending": ": Ordenar colunas de forma ascendente",
                    "sSortDescending": ": Ordenar colunas de forma descendente"
                }
            }
    });
    
    
                       
		$('#funcionario').on('changed.bs.select', function (e, clickedIndex, isSelected, previousValue) {
		  
		  var idFuncionario = $('#funcionario').val();
		  var funcionario = todosFuncionarios.find(f => f.id == idFuncionario);
		  
		  $("#nome-funcionario").html(funcionario.nome);
		  $("#cargo").html(funcionario.cargo);
		  $("#nome-gft").html(funcionario.localTrabalho.nome);
		  $("#matricula").html(funcionario.matricula);
		 
		});
		
		$('#vaga').on('changed.bs.select', function (e, clickedIndex, isSelected, previousValue) {
		  
		  var idVaga = $('#vaga').val();
		  var vaga = todasVagas.find(f => f.id == idVaga);
		  
		  $("#nome-vaga").html(vaga.nome);
		  $("#codigo-vaga").html(vaga.codigo_vaga);
		  $("#projeto").html(vaga.projeto);
		  $("#qtd-vaga").html(vaga.qtdVaga);
		  $("#descricaoVaga").html(vaga.descricao_vaga);
		});

} );






