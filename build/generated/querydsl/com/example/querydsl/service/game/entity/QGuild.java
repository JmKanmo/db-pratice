package com.example.querydsl.service.game.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QGuild is a Querydsl query type for Guild
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QGuild extends EntityPathBase<Guild> {

    private static final long serialVersionUID = 1766542435L;

    public static final QGuild guild = new QGuild("guild");

    public final ListPath<Character, QCharacter> characters = this.<Character, QCharacter>createList("characters", Character.class, QCharacter.class, PathInits.DIRECT2);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    public QGuild(String variable) {
        super(Guild.class, forVariable(variable));
    }

    public QGuild(Path<? extends Guild> path) {
        super(path.getType(), path.getMetadata());
    }

    public QGuild(PathMetadata metadata) {
        super(Guild.class, metadata);
    }

}

