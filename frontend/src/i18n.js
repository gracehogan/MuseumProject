// i18n.js
import i18n from 'i18next';
import { initReactI18next } from 'react-i18next';

import translationEN from './locales/en/translation.json';
import translationFR from './locales/fr/translation.json';
import translationCA from './locales/ca/translation.json';
import translationHI from './locales/hi/translation.json';
import translationES from './locales/es/translation.json';


const resources = {
  en: { translation: translationEN, },
  fr: { translation: translationFR, },
  ca: { translation: translationCA, },
  hi: { translation: translationHI, },
  es: { translation: translationES, },
};

i18n
  .use(initReactI18next)
  .init({
    resources,
    lng: 'en',
    fallbackLng: 'en',
    interpolation: {
      escapeValue: false,
    },
  });

export default i18n;
