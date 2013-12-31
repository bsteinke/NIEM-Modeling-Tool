package org.search.niem.uml.papyrus.diagram.clazz.providers;

import static org.search.niem.uml.papyrus.preferences.NIEMPreferenceConverter.getAggregationKind;
import static org.search.niem.uml.papyrus.preferences.PreferenceConstants.P_INITIAL_PROPERTY_AGGREGATION;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.uml2.uml.Property;
import org.search.niem.uml.papyrus.editors.Activator;

public class ElementInitializers extends org.eclipse.papyrus.uml.diagram.clazz.providers.ElementInitializers {
    public ElementInitializers() {
    }

    @Override
    public void init_Property_3012(final Property instance) {
        super.init_Property_3012(instance);
        try {
            instance.setAggregation(getAggregationKind(getPapyrusPreferences(), P_INITIAL_PROPERTY_AGGREGATION));
        } catch (final RuntimeException e) {
            Activator.INSTANCE.log(e);
        }
    }

    private IPreferenceStore getPapyrusPreferences() {
        return org.search.niem.uml.papyrus.Activator.getPlugin().getPreferenceStore();
    }
}
