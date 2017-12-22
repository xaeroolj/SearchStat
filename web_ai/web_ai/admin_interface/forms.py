from django import forms
from .models import ModelSite


class SitesManageForm(forms.ModelForm):

    class Meta:
        model = ModelSite
        fields = '__all__'

    multiple_select = forms.ModelMultipleChoiceField(queryset=ModelSite.objects.all(), required=False)
    name = forms.CharField(required=False, widget=forms.URLInput(attrs={'id': 'url', 'value': 'http://'}))

    # sites_choice = forms.MultipleChoiceField(required=False, choices=sites, label='Delete site:')
    #
