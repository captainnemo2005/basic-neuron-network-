package Links;

public interface Link {

	int getLinkOriginId();
	
	int getLinkDestinationId();
	
	float getLinkDisutility();
	
	void reset();
}
