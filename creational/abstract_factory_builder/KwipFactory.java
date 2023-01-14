package creational.abstract_factory_builder;

enum KwipSettings {
    BORING,
    ELDERLY,
    RARE,
    CHEAP,
    PRETTY,
    SLIM
}

public class KwipFactory implements AlienAnimalFactory {
    public AlienAnimal instantiate(CreationSettings settings) {
        switch (settings) {
            case BORING:
                return new Kwip(KwipShape.BALL, 4);
            case ELDERLY:
                return new Kwip(KwipShape.BALL, 5).setPrice(4800000).setSexuality(KwipSexuality.CAPITALIST);
            case RARE:
                return new Kwip(KwipShape.TETRAHEDRON, 50).setPrice(99999999).setSexuality(KwipSexuality.TERASEXUAL);
            case CHEAP:
                return new Kwip(KwipShape.CUBE, 3).setPrice(100000);
            case PRETTY:
                return new Kwip(KwipShape.BALL, 4).setPrice(55005500).setSexuality(KwipSexuality.TERASEXUAL);
            case SLIM:
                return new Kwip(KwipShape.CUBE, 1).setPrice(22002200);
            default:
                return new Kwip(KwipShape.BALL, 4);
        }
    }
}