package mekanism.common.inventory.container.tile.filter;

import javax.annotation.Nonnull;
import mekanism.common.inventory.container.MekanismContainerTypes;
import mekanism.common.tile.TileEntityOredictionificator;
import mekanism.common.tile.TileEntityOredictionificator.OredictionificatorFilter;
import mekanism.common.util.text.TextComponentUtil;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.text.ITextComponent;

//TODO: Should this be FilterEmptyContainer
public class OredictionificatorFilterContainer extends FilterContainer<TileEntityOredictionificator, OredictionificatorFilter> {

    public OredictionificatorFilterContainer(int id, PlayerInventory inv, TileEntityOredictionificator tile, int index) {
        super(MekanismContainerTypes.OREDICTIONIFICATOR_FILTER, id, inv, tile);
        if (index >= 0) {
            origFilter = tile.filters.get(index);
            filter = origFilter.clone();
        } else {
            filter = new OredictionificatorFilter();
        }
    }

    public OredictionificatorFilterContainer(int id, PlayerInventory inv, PacketBuffer buf) {
        this(id, inv, getTileFromBuf(buf, TileEntityOredictionificator.class), buf.readInt());
    }

    @Nonnull
    @Override
    public ITextComponent getDisplayName() {
        return TextComponentUtil.translate("mekanism.container.oredictionificator_filter");
    }
}