from django import forms
from django.contrib.auth.models import User
from django.contrib.auth.forms import UserChangeForm

from .models import Sites, Persons, Keywords, Users

from authapp.forms import EditForm


class SitesManageForm(forms.ModelForm):

    class Meta:
        model = Sites
        fields = '__all__'

    name = forms.CharField(required=False, widget=forms.URLInput(attrs={'id': 'url', 'placeholder': 'http://site.com'}))


class PersonsManageForm(forms.ModelForm):

    class Meta:
        model = Persons
        fields = '__all__'

    name = forms.CharField(required=True, widget=forms.TextInput(attrs={'id': 'person'}))


class KeywordsForm(forms.Form):

    class Meta:
        model = Keywords
        fields = '__all__'

    dropdown = forms.ModelChoiceField(queryset=None, required=False)
    multiple_select = forms.ModelMultipleChoiceField(queryset=None, required=False)

    def __init__(self, *args, **kwargs):
        super(KeywordsForm, self).__init__(*args, **kwargs)
        self.fields['dropdown'] = forms.ModelChoiceField(
            queryset=Persons.objects.all()
        )


class KeywordsAddForm(forms.Form):
    class Meta:
        model = Keywords
        fields = '__all__'

    keywords_add = forms.CharField(widget=forms.TextInput(attrs={'placeholder': 'keyword1, keyword2, etc.'}),
                                   required=False)


class UserAdminEditForm(UserChangeForm):
    class Meta:
        model = Users
        exclude = ('last_login_date', 'last_login', 'username' ,'token')