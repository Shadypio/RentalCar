<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<div class="jumbotron jumbotron-billboard">
	<div class="img"></div>
	<div class="container">
		<div class="row">
			<div class="col-lg-12">
				<h2>${head}</h2>
				<p>${heading}</p>
			</div>
		</div>
	</div>
</div>
<section class="container">
	<div class="row">

		<div class="card">
			<img class="card-img-top card-image"
				src="<c:url value="/static/images/offline_user.png" />"
				alt="Card image cap">
			<ul class="list-group list-group-flush">
				<li class="list-group-item">Nome: <span class="info-art">${customer.firstName}</span></li>
				<li class="list-group-item">Cognome: <span class="info-art">${customer.lastName}</span></li>
				<li class="list-group-item">Username: <span class="info-art">${customer.username}</span></li>
				<li class="list-group-item">Data di nascita: <span
					class="info-art">${customer.dateOfBirth}</span></li>
				<li class="list-group-item">Ruolo: <span class="info-art">${customer.role.roleName}</span></li>
			</ul>
		</div>

		
		<ul class="list-group list-group-flush">
		<c:if test="${noRentals != null}">
			<div class="alert alert-danger">
				<p>
					${noRentals}
				</p>
			</div>
		</c:if>
			<li class="list-group-item"><a
				href="<spring:url value="/rental/getfromcustomer/${customer.id}" /> "
				class="btn btn-warning table-buttons"> <span
					class="oi oi-list-rich"></span> Prenotazioni effettuate
			</a></li>
			<li class="list-group-item"><a
				href="<spring:url value="/customer/edit/${customer.id}" /> "
				class="btn btn-warning table-buttons"> <span
					class="oi oi-pencil"></span> Modifica profilo
			</a></li>
			<c:if test="${customer.role.id == 1}">
				<li class="list-group-item"><a
					href="<spring:url value="/customer/" /> "
					class="btn btn-warning table-buttons"> <span
						class="oi oi-people"></span> Gestione utenti
				</a></li>
				
				<li class="list-group-item"><a
					href="<spring:url value="/rental/" /> "
					class="btn btn-warning table-buttons"> <span
						class="oi oi-pencil"></span> Gestione Prenotazioni
				</a></li>

			
		</c:if>
		</ul>

	</div>
</section>