package StaticMapper;

import java.util.Collection;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration.AccessLevel;
import org.modelmapper.convention.MatchingStrategies;

public class ObjectMapperUtils {

	private static ModelMapper modelMapper = new ModelMapper();

	static {
		modelMapper.getConfiguration()
		.setMatchingStrategy(MatchingStrategies.STRICT)
		.setFieldMatchingEnabled(true)
		.setSkipNullEnabled(true)
		.setFieldAccessLevel(AccessLevel.PRIVATE);
	}
	
	private ObjectMapperUtils() {
		
	}
	
	/**
	 * One Singer entity(from ... .domain.Singer package) to Singer(from ...
	 * .data.Singer package) and reversed.
	 * 
	 * @param <T> source type
	 * @param <D> destination type
	 */
	public static <T, D> D map(final T source, Class<D> destination) {
		return modelMapper.map(source, destination);
	}

	/**
	 * List from Singer entity(from ... .domain.Singer package) to Singer(from ...
	 * .data.Singer package) and reversed.
	 * 
	 * @param <T> source type
	 * @param <D> destination type
	 */
	public static <T, D> Collection<D> mapAll(final Collection<T> sourceList, Class<D> destination) {
		return sourceList.stream().map(source -> map(source, destination)).collect(Collectors.toList());
	}

}
