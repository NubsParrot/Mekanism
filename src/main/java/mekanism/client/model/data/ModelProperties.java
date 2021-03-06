package mekanism.client.model.data;

import mekanism.common.tile.transmitter.TileEntitySidedPipe.ConnectionType;
import net.minecraftforge.client.model.data.ModelProperty;

public class ModelProperties {

    public static final ModelProperty<Boolean> COLOR = new ModelProperty<>();

    public static final ModelProperty<ConnectionType> DOWN_CONNECTION = new ModelProperty<>();
    public static final ModelProperty<ConnectionType> UP_CONNECTION = new ModelProperty<>();
    public static final ModelProperty<ConnectionType> NORTH_CONNECTION = new ModelProperty<>();
    public static final ModelProperty<ConnectionType> SOUTH_CONNECTION = new ModelProperty<>();
    public static final ModelProperty<ConnectionType> WEST_CONNECTION = new ModelProperty<>();
    public static final ModelProperty<ConnectionType> EAST_CONNECTION = new ModelProperty<>();
}