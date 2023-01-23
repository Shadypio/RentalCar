<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div class="jumbotron jumbotron-billboard">
	<div class="img"></div>
	<div class="container">
		<div class="row">
			<div class="col-lg-12">
				<h2>${Titolo}</h2>
				<p>${Titolo2}</p>
			</div>
		</div>
	</div>
</div>
<section class="container">
	<div class="row">
		<div class="col-md-6 col-sm-6">
			<h3 class="page-title">
				Risultati Ricerca: <small>Trovate ${numPrenotazioni}
					Prenotazioni</small>
			</h3>
		</div>
		<div class="col-md-6 col-sm-6">
			
		</div>


		<c:choose>

			<c:when test="${numPrenotazioni == 0}">
				<h3 class="page-title">Non è stata effettuata alcuna
					prenotazione</h3>
			</c:when>



			<c:otherwise>

				<table id="auto" class="table table-striped table-bordered">
					<thead>
						<tr>
							<th>ID Prenotazione</th>
							<th>Utente</th>
							<th>Data Inizio</th>
							<th>Data Fine</th>
						</tr>
					</thead>
					<tfoot>
					</tfoot>
					<tbody>
						<c:forEach items="${Prenotazioni}" var="prenotazione">
							<tr>
								<td>${prenotazione.idPrenotazione}</td>
								<td>${prenotazione.utenteRiferito.username}</td>
								<td>${prenotazione.dataInizio}</td>
								<td>${prenotazione.dataFine}</td>
								<td><a
									href=" <spring:url value="/prenotazione/infoprenotazione/${prenotazione.idPrenotazione}" /> "
									class="btn btn-primary"> <span class="oi oi-plus" /></span>
										Dettaglio
								</a></td>
								<td><a
									href="<spring:url value="/prenotazione/elimina/${prenotazione.idPrenotazione}" /> "
									class="btn btn-danger table-buttons"> <span
										class="oi oi-trash" /></span> Elimina
								</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</c:otherwise>
		</c:choose>
	</div>
</section>

