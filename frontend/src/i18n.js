import i18n from "i18next";
import { initReactI18next } from 'react-i18next'; // Import initReactI18next
import translationEN from './locales/en/translation.json';
import translationCA from './locales/ca/translation.json';
import translationES from './locales/es/translation.json';
import translationFR from './locales/fr/translation.json';
import translationHI from './locales/hi/translation.json';

// Define translations
const resources = {
  en: { translation: translationEN },
  hi: { translation: translationHI },
  es: { translation: translationES },
  fr: { translation: translationFR },
  ca: { translation: translationCA },
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
