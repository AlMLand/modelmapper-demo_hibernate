package com.morlandalex.jdbc_hibernate_jpa_5.serviceJPARepository;

import org.springframework.stereotype.Component;

@Component("objectMapperUtilsWithModelMapper")
public class ObjectMapperUtils {
	/*
	private ModelMapper modelMapper;

	public ObjectMapperUtils() {
		this.modelMapper = new ModelMapper();
		this.modelMapper.addConverter(handleSingerEntered);
		this.modelMapper.addConverter(populateExisting);
		this.modelMapper.getConfiguration()
		.setProvider(localDateProvider)
		.setMatchingStrategy(MatchingStrategies.STRICT)
		.setFieldAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PRIVATE);
	}
	
	private Provider<LocalDate> localDateProvider = new AbstractProvider<LocalDate>() {

		@Override
		protected LocalDate get() {
			return LocalDate.now();
		}
	};
	
	/**
	 * Converts instances of source type {Singer} to instances of destination type {SingerEntity}.
	 * @param <Singer> source type
	 * @param <SingerEntity> destination type
	 */
	/*private Converter<Singer, SingerEntity> handleSingerEntered = new Converter<Singer, SingerEntity>() {

		@Override
		public SingerEntity convert(MappingContext<Singer, SingerEntity> context) {
			context.getDestination().setFirstName(context.getSource().getFirstName());
			context.getDestination().setLastName(context.getSource().getLastName());
			context.getDestination().setBirthDate(context.getSource().getBirthDate());

			if (context.getSource().getAlbums().size() != 0) {
				for (Album album : context.getSource().getAlbums()) {
					context.getDestination().addAlbumEntity(album);
				}
			}

			if (context.getSource().getInstruments().size() != 0) {
				for (Instrument instrument : context.getSource().getInstruments()) {
					context.getDestination().addInstrumentEntity(instrument);
				}
			}

			return context.getDestination();
		}
	};
*/
	/**
	 * Converts instances of source type {SingerEntity} to instances of destination
	 * type {Singer}.
	 * 
	 * @param <SingerEntity> source type
	 * @param <Singer>       destination type
	 */
	/*private Converter<SingerEntity, Singer> populateExisting = new Converter<SingerEntity, Singer>() {

		@Override
		public Singer convert(MappingContext<SingerEntity, Singer> context) {
			context.getDestination().setId(context.getSource().getId());
			context.getDestination().setFirstName(context.getSource().getFirstName());
			context.getDestination().setLastName(context.getSource().getLastName());
			context.getDestination().setBirthDate(context.getSource().getBirthDate());
			context.getDestination().setCreatedBy(context.getSource().getCreatedBy());
			context.getDestination().setCreatedDate(context.getSource().getCreatedDate());
			context.getDestination().setCreatedDateTime(context.getSource().getCreatedDateTime());
			context.getDestination().setLastModifiedBy(context.getSource().getLastModifiedBy());
			context.getDestination().setLastModifiedDate(context.getSource().getLastModifiedDate());

			// add an empty albums for adding a new albums
			context.getDestination().getAlbums().add(new Album());
			for (AlbumEntity albumEntity : context.getSource().getAlbumEntities()) {
				context.getDestination().getAlbums()
						.add(new Album(albumEntity.getTitle(), albumEntity.getReleaseDate()));
			}

			// add an empty instruments for adding a new instruments
			context.getDestination().getInstruments().add(new Instrument());
			for (InstrumentEntity instrumentEntity : context.getSource().getInstrumentEntities()) {
				context.getDestination().getInstruments().add(new Instrument(instrumentEntity.getInstrument()));
			}

			return context.getDestination();
		}
	};
	*/
	/**
	 * One Singer entity(from ... .domain.Singer package) to Singer(from ... .data.Singer package) and reversed
	 * @param <T> source type
	 * @param <D> destination type
	 */
	/*public <T,D> D map(final T entity, Class<D> destinationType) {
		return modelMapper.map(entity, destinationType);
	}
	*/
	/**
	 * List from Singer entity(from ... .domain.Singer package) to Singer(from ... .data.Singer package) and reversed
	 * @param <T> source type
	 * @param <D> destination type
	 */
	/*public <T,D> List<D> mapAll(final Collection<T> entityList, Class<D> destinationType){
		return entityList.stream()
				.map(entity -> map(entity, destinationType))
				.collect(Collectors.toList());
	}
	*/

	
	
	//private static ModelMapper modelMapper = new ModelMapper();
	
	/**
	 * Converts instances of source type {Singer} to instances of destination type {SingerEntity}.
	 * 
	 * @param <Singer> source type
	 * @param <SingerEntity> destination type
	 */
/*	private static Converter<Singer, SingerEntity> handleSingerEntered = new Converter<Singer, SingerEntity>() {

		@Override
		public SingerEntity convert(MappingContext<Singer, SingerEntity> context) {
			context.getDestination().setId(context.getSource().getId());
			context.getDestination().setFirstName(context.getSource().getFirstName());
			context.getDestination().setLastName(context.getSource().getLastName());
			context.getDestination().setBirthDate(context.getSource().getBirthDate());
			context.getDestination().setCreatedBy(context.getSource().getCreatedBy());
			context.getDestination().setCreatedDate(context.getSource().getCreatedDate());
			context.getDestination().setCreatedDateTime(context.getSource().getCreatedDateTime());
			context.getDestination().setLastModifiedBy(context.getSource().getLastModifiedBy());
			context.getDestination().setLastModifiedDate(context.getSource().getLastModifiedDate());
			
			if (!context.getSource().getAlbums().isEmpty()) {
				for (Album album : context.getSource().getAlbums()) {
					context.getDestination().addAlbumEntity(album);
				}
			}
			
			if (!context.getSource().getInstruments().isEmpty()) {
				for (Instrument instrument : context.getSource().getInstruments()) {
					context.getDestination().addInstrumentEntity(instrument);
				}
			}
			
			return context.getDestination();
		}
	};
	
	/**
	 * Converts instances of source type {SingerEntity} to instances of destination type {Singer}.
	 * 
 	 * @param <SingerEntity> source type
 	 * @param <Singer> destination type
	 */
/*	private static Converter<SingerEntity, Singer> populateExisting = new Converter<SingerEntity, Singer>() {
		
		@Override
		public Singer convert(MappingContext<SingerEntity, Singer> context) {
			context.getDestination().setId(context.getSource().getId());
			context.getDestination().setFirstName(context.getSource().getFirstName());
			context.getDestination().setLastName(context.getSource().getLastName());
			context.getDestination().setBirthDate(context.getSource().getBirthDate());
			context.getDestination().setCreatedBy(context.getSource().getCreatedBy());
			context.getDestination().setCreatedDate(context.getSource().getCreatedDate());
			context.getDestination().setCreatedDateTime(context.getSource().getCreatedDateTime());
			context.getDestination().setLastModifiedBy(context.getSource().getLastModifiedBy());
			context.getDestination().setLastModifiedDate(context.getSource().getLastModifiedDate());
			
			// add an empty albums for adding a new albums
			context.getDestination().getAlbums().add(new Album());
			for(AlbumEntity albumEntity : context.getSource().getAlbumEntities()) {
				context.getDestination().getAlbums().add(new Album(albumEntity.getTitle(), albumEntity.getReleaseDate()));
			}
			
			// add an empty instruments for adding a new instruments
			context.getDestination().getInstruments().add(new Instrument());
			for(InstrumentEntity instrumentEntity : context.getSource().getInstrumentEntities()) {
				context.getDestination().getInstruments().add(new Instrument(instrumentEntity.getInstrument()));
			}
			
			return context.getDestination();
		}
	};
	
	static {
		Provider<LocalDate> localDateProvider = new AbstractProvider<LocalDate>() {

			@Override
			protected LocalDate get() {
				return LocalDate.now();
			}
		};
		
		modelMapper.addConverter(handleSingerEntered);
		modelMapper.addConverter(populateExisting);
		modelMapper.getConfiguration()
		.setProvider(localDateProvider)
		.setMatchingStrategy(MatchingStrategies.STRICT);
	}
*/	
	/**
	 * One Singer entity(from ... .domain.Singer package) to Singer(from ... .data.Singer package) and reversed.
	 * 
	 * @param <T> source type
	 * @param <D> destination type
	 */
/*	public static <T,D> D map(final T entity, Class<D> destinationType) {
		return modelMapper.map(entity, destinationType);
	}
	
	/**
	 * List from Singer entity(from ... .domain.Singer package) to Singer(from ... .data.Singer package) and reversed.
	 * 
	 * @param <T> source type
	 * @param <D> destination type
	 */
/*	public static <T,D> List<D> mapAll(final Collection<T> entityList, Class<D> destinationType){
		return entityList.stream()
				.map(entity -> map(entity, destinationType))
				.collect(Collectors.toList());
	}
*/	
}
