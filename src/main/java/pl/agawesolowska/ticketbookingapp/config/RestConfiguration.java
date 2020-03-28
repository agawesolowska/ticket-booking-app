package pl.agawesolowska.ticketbookingapp.config;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.metamodel.EntityType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;

import pl.agawesolowska.ticketbookingapp.entity.Cinema;
import pl.agawesolowska.ticketbookingapp.entity.Movie;
import pl.agawesolowska.ticketbookingapp.entity.Room;
import pl.agawesolowska.ticketbookingapp.entity.Row;
import pl.agawesolowska.ticketbookingapp.entity.Screening;

/**
 * @author Aga Wesołowska
 *
 */
@Configuration
public class RestConfiguration implements RepositoryRestConfigurer {

	private EntityManager entityManager;

	@Autowired
	public RestConfiguration(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {

		HttpMethod[] unsupportedActions = { HttpMethod.POST, HttpMethod.PUT, HttpMethod.DELETE };

		// disabling HTTP methods for selected entities: POST, PUT, DELETE

		config.getExposureConfiguration().forDomainType(Cinema.class)
				.withItemExposure((metdata, httpMethods) -> httpMethods.disable(unsupportedActions))
				.withCollectionExposure((metdata, httpMethods) -> httpMethods.disable(unsupportedActions));

		config.getExposureConfiguration().forDomainType(Movie.class)
				.withItemExposure((metdata, httpMethods) -> httpMethods.disable(unsupportedActions))
				.withCollectionExposure((metdata, httpMethods) -> httpMethods.disable(unsupportedActions));

		config.getExposureConfiguration().forDomainType(Room.class)
				.withItemExposure((metdata, httpMethods) -> httpMethods.disable(unsupportedActions))
				.withCollectionExposure((metdata, httpMethods) -> httpMethods.disable(unsupportedActions));

		config.getExposureConfiguration().forDomainType(Row.class)
				.withItemExposure((metdata, httpMethods) -> httpMethods.disable(unsupportedActions))
				.withCollectionExposure((metdata, httpMethods) -> httpMethods.disable(unsupportedActions));

		config.getExposureConfiguration().forDomainType(Screening.class)
				.withItemExposure((metdata, httpMethods) -> httpMethods.disable(unsupportedActions))
				.withCollectionExposure((metdata, httpMethods) -> httpMethods.disable(unsupportedActions));

		// calling an internal helper method
		exposeIds(config);

	}

	// exposing entity ids
	private void exposeIds(RepositoryRestConfiguration config) {

		// getting a list of all entity classes from the entity manager
		Set<EntityType<?>> entities = entityManager.getMetamodel().getEntities();

		// creating an array of the entity types
		List<Class> entityClasses = new ArrayList<>();

		// getting the entity types for the entities
		for (EntityType tempEntityType : entities) {
			entityClasses.add(tempEntityType.getJavaType());
		}

		// exposing the entity ids for the array of entity/domain types
		Class[] domainTypes = entityClasses.toArray(new Class[0]);
		config.exposeIdsFor(domainTypes);

	}

}
