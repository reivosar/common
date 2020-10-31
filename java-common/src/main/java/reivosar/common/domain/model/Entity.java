package reivosar.common.domain.model;

public abstract class Entity<ID extends Identity<ID>, ENTITY>
	extends Model {

	public abstract ID publicId();
}
